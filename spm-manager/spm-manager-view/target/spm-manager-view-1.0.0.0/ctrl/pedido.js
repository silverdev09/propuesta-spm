

__app.controller("spm$pedido", function ($scope, $http) {
    const PATH = "manager/spm";
    $scope.view = new ViewHandler(PATH, 'pedido', ['inbox','crear', 'editar', 'borrar']);
    $scope.part = new PartHandler(PATH, 'pedido');
    var pedidoServ = new ServHandler(PATH, 'pedido', ['listar', 'crear', 'editar', 'borrar']);
    var pedidoPanel = $scope.panel = new PanelHandler();
    var pedidoData = $scope.data = {
        list: [],
        current: undefined
    };
    var pedidoFilter = $scope.filter = {
        apply: function () {
            var call = $http.post(pedidoServ.listar, {});
            call.success(function (data) {
                pedidoData.list = data;
            });
            call.error(function () {
                pedidoData.list = [];
            });
        },
        clear: function () {
            pedidoData.list = [];
        }
    };
    pedidoFilter.apply();
    $scope.table = {
        toggle: function (value) {
            if (pedidoData.current && pedidoData.current.idPedido === value.idPedido) {
                pedidoData.current = null;
            } else {
                pedidoData.current = angular.copy(value, {});
            }
        },
        in: function (value) {
            return pedidoData.current && pedidoData.current.idPedido === value.idPedido;
        },
        isOneSelect: function () {
            return pedidoData.current && true;
        },
        isMoreSelect: function () {
            return pedidoData.current && true;
        }
    };
    $scope.action = {
        open: function (name) {
            if (name === 'crear') {
                pedidoData.current = {};
            }
            pedidoPanel.open(name);
        },
        cancel: function (name) {
            pedidoData.current = undefined;
            pedidoPanel.close(name);
        },
        create: function () {
            var call = $http.post(pedidoServ.crear, pedidoData.current);
            call.success(function () {
                pedidoData.current = {};
                pedidoFilter.apply();
                pedidoPanel.close('crear');
            });
        },
        update: function () {
            var call = $http.post(pedidoServ.editar, pedidoData.current);
            call.success(function () {
                pedidoData.current = undefined;
                pedidoFilter.apply();
                pedidoPanel.close('editar');
            });
        },
        remove: function () {
            var call = $http.post(pedidoServ.borrar, pedidoData.current);
            call.success(function () {
                pedidoData.current = undefined;
                pedidoFilter.apply();
                pedidoPanel.close('borrar');
            });
        }
    };
});
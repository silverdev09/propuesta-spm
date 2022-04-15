

__app.controller("spm$producto", function ($scope, $http) {
    const PATH = "manager/spm";
    $scope.view = new ViewHandler(PATH, 'producto', ['inbox','crear', 'editar', 'borrar']);
    $scope.part = new PartHandler(PATH, 'producto', ['deta']);
    var productoServ = new ServHandler(PATH, 'producto', ['listar', 'crear', 'editar', 'borrar']);
    var productoPanel = $scope.panel = new PanelHandler();
    var productoData = $scope.data = {
        filter: {},
        list: [],
        current: undefined
    };
    var productoFilter = $scope.filter = {
        apply: function () {
            var call = $http.post(productoServ.filter, productoData.filter);
            call.success(function (data) {
                productoData.list = data;
            });
            call.error(function () {
                productoData.list = [];
            });
        },
        clear: function () {
            productoData.list = [];
        }
    };
    productoFilter.apply();
    $scope.table = {
        toggle: function (value) {
            if (productoData.current && productoData.current.idProducto === value.idProducto) {
                productoData.current = null;
            } else {
                productoData.current = angular.copy(value, {});
            }
        },
        in: function (value) {
            return productoData.current && productoData.current.idProducto === value.idProducto;
        },
        isOneSelect: function () {
            return productoData.current && true;
        },
        isMoreSelect: function () {
            return productoData.current && true;
        }
    };
    $scope.action = {
        open: function (name) {
            if (name === 'crear') {
                productoData.current = {};
            }
            productoPanel.open(name);
        },
        cancel: function (name) {
            productoData.current = undefined;
            productoPanel.close(name);
        },
        create: function () {
            var call = $http.post(productoServ.crear, productoData.current);
            call.success(function () {
                productoData.current = {};
                productoFilter.apply();
                productoPanel.close('crear');
            });
        },
        update: function () {
            var call = $http.post(productoServ.editar, productoData.current);
            call.success(function () {
                productoData.current = undefined;
                productoFilter.apply();
                productoPanel.close('editar');
            });
        },
        remove: function () {
            var call = $http.post(productoServ.borrar, productoData.current);
            call.success(function () {
                productoData.current = undefined;
                productoFilter.apply();
                productoPanel.close('borrar');
            });
        }
    };
});
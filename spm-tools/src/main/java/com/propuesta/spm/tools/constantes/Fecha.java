
package com.propuesta.spm.tools.constantes;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sipaco
 */
public class Fecha {

    public static Date fechaActual() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

}

package cl.chilepost.ejemplo_1.modelos;

import com.google.gson.annotations.SerializedName;

public class ParametrosModel
{
    /*
        "ORDEN": "1",
        "PAR_TABLA": "valor 1",
        "PAR_CODINT": "Recurso no disponible",
        "PAR_DESCRIPCION": "Recurso no disponible",
        "PAR_ALF1": "Recurso no disponible",
        "PAR_ALF2": 0,
        "PAR_NUM1": "Recurso no disponible",
        "PAR_NUM2": "Recurso no disponible",
        "PAR_ALF3": "Recurso no disponible"
    * */
   private String orden,par_tabla,par_codint,par_descripcion,par_alf1,par_alf2,par_num1,par_num2,getPar_alf3;

    public ParametrosModel(String orden, String par_tabla, String par_codint, String par_descripcion, String par_alf1, String par_alf2, String par_num1, String par_num2, String getPar_alf3) {
        this.orden = orden;
        this.par_tabla = par_tabla;
        this.par_codint = par_codint;
        this.par_descripcion = par_descripcion;
        this.par_alf1 = par_alf1;
        this.par_alf2 = par_alf2;
        this.par_num1 = par_num1;
        this.par_num2 = par_num2;
        this.getPar_alf3 = getPar_alf3;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getPar_tabla() {
        return par_tabla;
    }

    public void setPar_tabla(String par_tabla) {
        this.par_tabla = par_tabla;
    }

    public String getPar_codint() {
        return par_codint;
    }

    public void setPar_codint(String par_codint) {
        this.par_codint = par_codint;
    }

    public String getPar_descripcion() {
        return par_descripcion;
    }

    public void setPar_descripcion(String par_descripcion) {
        this.par_descripcion = par_descripcion;
    }

    public String getPar_alf1() {
        return par_alf1;
    }

    public void setPar_alf1(String par_alf1) {
        this.par_alf1 = par_alf1;
    }

    public String getPar_alf2() {
        return par_alf2;
    }

    public void setPar_alf2(String par_alf2) {
        this.par_alf2 = par_alf2;
    }

    public String getPar_num1() {
        return par_num1;
    }

    public void setPar_num1(String par_num1) {
        this.par_num1 = par_num1;
    }

    public String getPar_num2() {
        return par_num2;
    }

    public void setPar_num2(String par_num2) {
        this.par_num2 = par_num2;
    }

    public String getGetPar_alf3() {
        return getPar_alf3;
    }

    public void setGetPar_alf3(String getPar_alf3) {
        this.getPar_alf3 = getPar_alf3;
    }
}

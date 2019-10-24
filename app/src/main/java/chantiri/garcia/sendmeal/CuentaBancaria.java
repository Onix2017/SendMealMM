package chantiri.garcia.sendmeal;

import androidx.annotation.Nullable;

import java.util.Objects;

public class CuentaBancaria {
    private Integer id;
    private String cbu;
    private String alias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public CuentaBancaria(Integer id, String cbu, String alias) {
        this.id = id;
        this.cbu = cbu;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "id=" + id +
                ", cbu='" + cbu + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaBancaria that = (CuentaBancaria) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cbu, that.cbu) &&
                Objects.equals(alias, that.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cbu, alias);
    }
}

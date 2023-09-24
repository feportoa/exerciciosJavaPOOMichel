package exercicio1;

public class Casa {

    private short voltsSocket;

    protected Casa(short v) {
        voltsSocket = v;
    }

    protected Casa() {
        voltsSocket = 220;
    }

    protected short getVoltsSocket() {
        return this.voltsSocket;
    }

    protected void setVoltsSocket(short v) {
        this.voltsSocket = v;
    }
}

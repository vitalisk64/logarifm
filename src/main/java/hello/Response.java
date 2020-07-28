package hello;

public class Response {
    public String getError() {
        return error;
    }

    public Response(String error) {
        this.error = error;
        this.response = response;
    }

    public Response(double response) {
        this.response = response;
    }

    public void setError(String error) {
        this.error = error;
    }

    public double getResponse() {
        return response;
    }

    public void setResponse(double response) {
        this.response = response;
    }

    public String error;
    public double response;
}

package qwuerty.backend.models.jwt;


import java.io.Serializable;

public class JwtResponse implements Serializable {


    private static final long serialVersionUID = 8777512816384987811L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
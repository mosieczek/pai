import { useEffect } from "react";
import { logout } from "../services/authService";

export const Logout = () => {
    useEffect(() => {
        logout();
        window.location = "/";
    }, []);
    return null;
};


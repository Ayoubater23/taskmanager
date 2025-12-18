import { createContext, useContext, useState } from 'react';
import api from './api.jsx';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(() => {
        const token = localStorage.getItem('jwt_token');
        const userId = localStorage.getItem('user_id');
        return token && userId ? { token, userId: Number(userId) } : null;
    });

    const login = async (email, password) => {
        try {
            const res = await api.post('/auth/login', { email, password });
            const { token, userId } = res.data;

            localStorage.setItem('jwt_token', token);
            localStorage.setItem('user_id', userId);

            setUser({ token, userId });
            return true;
        } catch (err) {
            return err.response?.data?.message || 'Invalid credentials';
        }
    };

    const logout = () => {
        localStorage.clear();
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, isAuthenticated: !!user, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);

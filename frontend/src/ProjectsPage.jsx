import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './Auth/AuthContext.jsx';

const ProjectsPage = () => {
    const { logout } = useAuth();
    const navigate = useNavigate();

    const handleLogout = () => {
        logout();
        navigate('/login');
    };

    return (
        <div>
            <h1>Projects List Page (Placeholder)</h1>
            <p>This is where your projects will load after logging in.</p>

            <button onClick={handleLogout}>
                Logout
            </button>
        </div>
    );
};

export default ProjectsPage;

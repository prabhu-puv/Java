import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    localStorage.setItem('isLoggedIn', 'true');
    navigate('/home');
  };

  return (
    <div style={{ textAlign: 'center', padding: '2rem' }}>
      <h2>Login</h2>
      <form onSubmit={handleLogin} style={{ display: 'flex', flexDirection: 'column', gap: '1rem', maxWidth: '300px', margin: 'auto' }}>
        <input type="email" placeholder="Email" required value={email} onChange={e => setEmail(e.target.value)} />
        <input type="password" placeholder="Password" required value={password} onChange={e => setPassword(e.target.value)} />
        <button type="submit">Login</button>
      </form>
      <p onClick={() => navigate('/forgot')} style={{ cursor: 'pointer', color: 'blue' }}>Forgot Password?</p>
      <p onClick={() => navigate('/signup')} style={{ cursor: 'pointer', color: 'blue' }}>Don’t have an account? Sign up</p>
    </div>
  );
}

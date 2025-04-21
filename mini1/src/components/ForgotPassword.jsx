import React, { useState } from 'react';

export default function ForgotPassword() {
  const [email, setEmail] = useState('');

  const handleReset = (e) => {
    e.preventDefault();
    alert(`Password reset link sent to ${email}`);
  };

  return (
    <div style={{ textAlign: 'center', padding: '2rem' }}>
      <h2>Forgot Password</h2>
      <form onSubmit={handleReset} style={{ display: 'flex', flexDirection: 'column', gap: '1rem', maxWidth: '300px', margin: 'auto' }}>
        <input type="email" placeholder="Enter your email" value={email} onChange={e => setEmail(e.target.value)} required />
        <button type="submit">Send Reset Link</button>
      </form>
    </div>
  );
}

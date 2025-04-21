import React, { useState } from 'react';

const ItemForm = ({ onAddItem }) => {
  const [form, setForm] = useState({
    title: '',
    category: '',
    description: '',
    location: ''
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onAddItem(form);
    setForm({ title: '', category: '', description: '', location: '' });
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-4">
      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <input name="title" className="p-3 border rounded-lg shadow-sm" placeholder="Item Title" value={form.title} onChange={handleChange} required />
        <input name="category" className="p-3 border rounded-lg shadow-sm" placeholder="Category" value={form.category} onChange={handleChange} required />
      </div>
      <textarea name="description" className="w-full p-3 border rounded-lg shadow-sm" placeholder="Description (optional)" value={form.description} onChange={handleChange} rows="3" />
      <input name="location" className="w-full p-3 border rounded-lg shadow-sm" placeholder="Location" value={form.location} onChange={handleChange} required />
      <button type="submit" className="w-full bg-blue-600 text-white py-3 rounded-xl font-semibold hover:bg-blue-700 transition">
        ➕ Post Item
      </button>
    </form>
  );
};

export default ItemForm;

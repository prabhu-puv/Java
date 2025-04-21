import React from 'react';

const ItemList = ({ items }) => {
  return (
    <div>
      <h2 className="text-2xl font-semibold text-blue-600 mb-4">Available Items</h2>
      {items.length === 0 ? (
        <p className="text-gray-400 italic">No items yet. Be the first to post!</p>
      ) : (
        <div className="grid gap-4 sm:grid-cols-1 md:grid-cols-2">
          {items.map(item => (
            <div key={item._id} className="bg-blue-50 p-4 rounded-xl shadow hover:shadow-lg transition">
              <h3 className="text-xl font-bold text-blue-700">{item.title}</h3>
              <p className="text-gray-600">{item.description}</p>
              <div className="mt-2 text-sm text-gray-500">
                <p><strong>📦 Category:</strong> {item.category}</p>
                <p><strong>📍 Location:</strong> {item.location}</p>
              </div>
            </div>
          ))}
        </div>
      )}
      <button>Logout</button>
    </div>
  );
};

export default ItemList;

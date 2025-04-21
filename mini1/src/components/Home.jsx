import React, { useState } from "react";
import ItemForm from "./ItemForm";
import ItemList from "./ItemList";

export default function Home() {
  const [items, setItems] = useState([]);

  const handleAddItem = (item) => {
    const newItem = { ...item, _id: Date.now().toString() };
    setItems((prev) => [newItem, ...prev]);
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-blue-100 to-blue-300 p-4">
      <div className="bg-white rounded-3xl shadow-2xl p-8 w-full max-w-3xl space-y-6">
        <h1 className="text-4xl font-bold text-center text-blue-700 mb-4">
          KarmaKart 💫
        </h1>
        <p className="text-center text-gray-500 mb-6">Post or explore items nearby</p>
        <ItemForm onAddItem={handleAddItem} />
        <hr className="my-6 border-blue-200" />
        <ItemList items={items} />
      </div>
    </div>
  );
}

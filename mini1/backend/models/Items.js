const mongoose = require("mongoose");

const itemSchema = new mongoose.Schema({
  title: String,
  category: String,
  description: String,
  location: String,
});

module.exports = mongoose.model("Item", itemSchema);

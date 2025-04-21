const express = require("express");
const router = express.Router();
const Item = require("../models/Item");

router.get("/", async (req, res) => {
  const items = await Item.find().sort({ _id: -1 });
  res.json(items);
});

router.post("/", async (req, res) => {
  const newItem = new Item(req.body);
  await newItem.save();
  res.json(newItem);
});

module.exports = router;
    
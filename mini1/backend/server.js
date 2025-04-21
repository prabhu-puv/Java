const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

mongoose.connect("mongodb://127.0.0.1:27017/karmakart", {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

const itemRoutes = require("./routes/items");
app.use("/api/items", itemRoutes);

const PORT = 5000;
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});

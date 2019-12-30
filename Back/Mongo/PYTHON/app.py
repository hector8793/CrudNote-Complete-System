from flask import Flask
from flask_pymongo import PyMongo

app = Flask(__name__)
app.secret_key = ""
app.config["MONGO_URI"] = "mongodb://localhost:27017/mean-db"
mongo = PyMongo(app)
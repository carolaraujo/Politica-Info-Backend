from flask import flask 
app = Flask(__name__)

@app.route('/')
def politica_info():
    return "Política Info"
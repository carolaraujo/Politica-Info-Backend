import requests
import json
from flask import Flask

app = Flask(__name__)

url = 'https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome'
parametros = {}
resposta = requests.request("GET", url, params = parametros)
objetos = json.loads(resposta.text)
dados = objetos['dados']
dados_parametros = objetos['dados']
print(dados_parametros)




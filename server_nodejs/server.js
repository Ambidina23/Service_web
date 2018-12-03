//impoter le module le module "express"
var express = require('express');

//instaciation du server
var server =express();

//parametrage du server
    //configuration des routes(recuperer des infos dans le server(avec la function callback aprelée la route demandée:req=rquest et res=response))
    server.get('/', function(req, res){
        res.setHeader('Content-Type', 'text/html');
        res.status(200).send('<h1>Bonjour sur mon server</h1>');

    });

    //Lancement du server
    server.listen(8080, function(){
        console.log('notre server a demarré:')

    });
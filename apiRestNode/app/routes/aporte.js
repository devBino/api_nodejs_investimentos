const verificaToken = require('../middlewares/verificaToken')
const aporte        = require('../controllers/aporte')

module.exports = function(app){

    app.get('/aportes',verificaToken,aporte.listar)
    app.post('/aportes',verificaToken,aporte.salvar)
    app.delete('/aportes/:id',verificaToken,aporte.deletar)
    app.put('/aportes',verificaToken,aporte.alterar)

}
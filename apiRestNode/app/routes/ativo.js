const verificaToken = require('../middlewares/verificaToken')
const ativo         = require('../controllers/ativo')

module.exports = function(app){

    app.get('/ativos',verificaToken,ativo.listar)
    app.post('/ativos',verificaToken,ativo.salvar)
    app.delete('/ativos/:id',verificaToken,ativo.deletar)
    app.put('/ativos',verificaToken,ativo.alterar)

}
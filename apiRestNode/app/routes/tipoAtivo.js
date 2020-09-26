const tipoAtivo     = require('../controllers/tipoAtivo')
const verificaToken = require('../middlewares/verificaToken')

module.exports = function(app){
    
    app.get('/tipoAtivos', verificaToken, tipoAtivo.listar )
    app.post('/tipoAtivos', verificaToken, tipoAtivo.salvar )
    app.delete('/tipoAtivos/:id',verificaToken, tipoAtivo.deletar )
    app.put('/tipoAtivos', verificaToken, tipoAtivo.alterar )

}
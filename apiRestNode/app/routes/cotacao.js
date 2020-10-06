const verificaToken = require('../middlewares/verificaToken')
const cotacao       = require('../controllers/dadosCotacao')

module.exports = function(app){
    app.get('/cotacao/:ativo', verificaToken, cotacao.getCotacaoAtivo)
}
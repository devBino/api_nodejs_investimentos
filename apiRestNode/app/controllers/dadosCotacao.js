const httpCodes = require('../repositories/httpCodes')
const mdCotacao = require('../models/cotacao')

class Cotacao{

    async getCotacaoAtivo(req,res){
        try{
            let dadosCotacao = await mdCotacao.getCotacaoAtivo(req)
            httpCodes.response(dadosCotacao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

}

module.exports = new Cotacao()
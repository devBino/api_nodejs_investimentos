const token     = require('../repositories/token')
const paramsSql = require('../repositories/parametrosSql')
const mdUsuario = require('../models/usuario')

class Autenticacao{
    
    async autenticar(req,res){
        try{
            let params          = await paramsSql.limpar(req.params)
            let dadosUsuario    = await mdUsuario.checarCredencial(params)
            let dadosToken      = await token.gerar(dadosUsuario.data)
            
            if( dadosToken.token == undefined ){
                res.status(401).json({message:'Não é possível autenticar com os parâmetros enviados...'})
            }

            res.status(200).json(dadosToken)

        }catch(e){
            res.send({data:[],messagem:'Erro ao tentar autenticar',success:false})
        }
    }

}

module.exports = new Autenticacao()
const httpCodes     = require('../repositories/httpCodes')
const paramsSql     = require('../repositories/parametrosSql')
const mdAtivo       = require('../models/ativo')

class Ativo{

    async listar(req,res){
        try{
            let lista = await mdAtivo.listar()
            httpCodes.response(lista,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async salvar(req,res){
        try{
            let params      = await paramsSql.limpar(req.body)
            let resultAcao  = await mdAtivo.salvar(params.params)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async deletar(req,res){
        try{
            let params      = await paramsSql.limpar(req.params)
            let resultAcao  = await mdAtivo.deletar(params.params.id)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async alterar(req,res){
        try{
            let params      = await paramsSql.limpar(req.body)
            let resultAcao  = await mdAtivo.prepareUpdate(params.params)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }


}

module.exports = new Ativo()
const httpCodes     = require('../repositories/httpCodes');
const mdAporte      = require('../models/aporte')
const paramsSql     = require('../repositories/parametrosSql')

class Aporte{

    async listar(req,res){
        try{
            let lista = await mdAporte.listar()
            httpCodes.response(lista,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async salvar(req,res){
        try{
            let params      = await paramsSql.limpar(req.body)
            let resultAcao  = await mdAporte.salvar(params.params)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async deletar(req,res){
        try{
            let params      = await paramsSql.limpar(req.params)
            let resultAcao  = await mdAporte.deletar(params.params.id)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async alterar(req,res){
        try{
            let params      = await paramsSql.limpar(req.body)
            let resultAcao  = await mdAporte.prepareUpdate(params.params)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

}

module.exports = new Aporte()
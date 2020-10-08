const httpCodes     = require('../repositories/httpCodes')
const paramsSql     = require('../repositories/parametrosSql')
const mdTipoAtivo   = require('../models/tipoAtivo')

class TipoAtivo{

    constructor(){

    }

    async listar(req,res){
        try{
            let lista = await mdTipoAtivo.listar()
            httpCodes.response(lista,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async salvar(req,res){
        try{
            let params      = await paramsSql.limpar(req.body)
            let resultAcao  = await mdTipoAtivo.salvar(params.params)
            
            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async deletar(req,res){
        try{
            let params      = await paramsSql.limpar(req.params)
            let resultAcao  = await mdTipoAtivo.deletar(params.params.id)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async alterar(req,res){
        try{
            let params      = await paramsSql.limpar(req.body)
            let resultAcao  = await mdTipoAtivo.prepareUpdate(params.params)

            httpCodes.response(resultAcao,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    async agrupar(req,res){
        try{
            let params      = await paramsSql.limpar(req.params)
            let lista       = await mdTipoAtivo.agrupar(params);

            httpCodes.response(lista,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

}

module.exports = new TipoAtivo()
const Db = require('../repositories/db')

class Model{

    constructor(){
        this._Db = Db
        this._erroQuery = {data:undefined,message:'Erro ao tentar executar Query...',success:false}
        this._sqlInsert = null
        this._sqlDelete = null
        this._sqlUpdate = null
        this._nomeBanco = 'ativos'
    }

    async listar(sql){
        try{
            let returnDados = await Db.executeQuery(sql)
            return returnDados
        }catch(e){
            return this._erroQuery
        }
    }

    async salvar(params){
        try{            
            let resultAcao = await Db.executeQuery(this._sqlInsert,this._nomeBanco,params)
            return resultAcao
        }catch(e){
            return this._erroQuery
        }
    }

    async deletar(id){
        try{
            let sql = this._sqlDelete.replace('<id>',id)
            let resultAcao = await Db.executeQuery(sql,this._nomeBanco)
            return resultAcao
        }catch(e){
            return this._erroQuery
        }
    }

    async alterar(){
        try{
            let resultAcao = await Db.executeQuery(this._sqlUpdate,this._nomeBanco)
            return resultAcao
        }catch(e){
            return this._erroQuery
        }
    }


}

module.exports = Model
const Model = require('./model')

class Aporte extends Model{
    
    constructor(){
        super()
        this.setSqlQuery()
        this.setSqlInsert()
        this.setSqlDelete()
        this.campos = ['cdAporte','cdAtivo','vlAporte','qtde','subTotal','dtAporte','taxaRetorno','cdStatus']
    }

    setSqlQuery(){
        this._sqlQuery = 'select a.*,at.nmAtivo from aporte a inner join ativo at on(a.cdAtivo=at.cdAtivo)'
    }

    setSqlInsert(){
        this._sqlInsert = 'insert into aporte set ?'
    }

    setSqlDelete(){
        this._sqlDelete = 'delete from aporte where cdAporte=<id>'
    }

    async prepareUpdate(params){
        this._sqlUpdate = `update aporte set <set> where <where>`
        var arrSet = []

        Object.keys(params).forEach(function(item){
            if( item != "id" ){
                if( typeof(params[item]) == "number" ){
                    var strSet = `${item}=${params[item]}`
                }else{
                    var strSet = `${item}="${params[item]}"`
                }

                arrSet.push(strSet)
            }
        })

        var strWhere = `cdAporte=${params.id}`
        var strArrSet = arrSet.toLocaleString()
        
        this._sqlUpdate = this._sqlUpdate.replace("<set>",strArrSet)
        this._sqlUpdate = this._sqlUpdate.replace("<where>",strWhere)

        return await this.alterar()
    }


}

module.exports = new Aporte()
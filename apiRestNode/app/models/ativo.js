const Model = require('./model')

class Ativo extends Model{
    
    constructor(){
        super()
        this.setSqlQuery()
        this.setSqlInsert()
        this.seSqlDelete()
        this.campos = ['cdAtivo','nmAtivo','vlAtivo','taxaAmin','taxaCustodia','taxaPerformace','cdTipo','cdStatus']
    }

    setSqlQuery(){
        this._sqlQuery = 'select * from ativo'
    }

    setSqlInsert(){
        this._sqlInsert = 'insert into ativo set ?'
    }

    seSqlDelete(){
        this._sqlDelete = 'delete from ativo where cdAtivo=<id>'
    }

    async prepareUpdate(params){
        this._sqlUpdate = `update ativo set <set> where <where>`
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

        var strWhere = `cdAtivo=${params.id}`
        var strArrSet = arrSet.toLocaleString()
        
        this._sqlUpdate = this._sqlUpdate.replace("<set>",strArrSet)
        this._sqlUpdate = this._sqlUpdate.replace("<where>",strWhere)

        return await this.alterar()
    }


}

module.exports = new Ativo()
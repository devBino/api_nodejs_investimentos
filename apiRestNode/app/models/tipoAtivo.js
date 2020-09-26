const Model = require('./model')

class TipoAivo extends Model{
    
    constructor(){
        super()
        this.getSqlInsert()
        this.getSqlDelete()
    }

    getSqlInsert(){
        this._sqlInsert = `insert into tipo_ativo set ?`
    }
    getSqlDelete(){
        this._sqlDelete = `delete from tipo_ativo where cdTipo=<id>`
    }
    
    async prepareUpdate(params){
        this._sqlUpdate = `update tipo_ativo set <set> where <where>`
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

        var strWhere = `cdTipo=${params.id}`
        var strArrSet = arrSet.toLocaleString()
        
        this._sqlUpdate = this._sqlUpdate.replace("<set>",strArrSet)
        this._sqlUpdate = this._sqlUpdate.replace("<where>",strWhere)

        return await this.alterar()
    }

    

}

module.exports = new TipoAivo()
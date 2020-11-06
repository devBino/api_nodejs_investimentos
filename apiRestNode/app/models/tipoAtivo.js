const Model = require('./model')

class TipoAivo extends Model{
    
    constructor(){
        super()
        this.setSqlQuery()
        this.setSqlInsert()
        this.setSqlDelete()
        this.setSqlAgrupamento()
        this.campos = ['cdTipo','nmTipo','cdStatus']
    }

    setSqlQuery(){
        this._sqlQuery = 'select * from tipo_ativo'
    }

    setSqlInsert(){
        this._sqlInsert = `insert into tipo_ativo set ?`
    }
    setSqlDelete(){
        this._sqlDelete = `delete from tipo_ativo where cdTipo=<id>`
    }
    setSqlAgrupamento(){
        this._sqlAgrupamento = `
            select ta.cdTipo, nmTipo as Tipo,count(a.cdAtivo) as Qtde_Ativos, sum(ap.subTotal) as Total_Aportado
            from tipo_ativo ta join ativo a on a.cdTipo = ta.cdTipo
            left join aporte ap on ap.cdAtivo=a.cdAtivo
            group by ta.cdTipo
        `
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
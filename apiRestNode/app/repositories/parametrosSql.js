class ParametrosSql{
    
    constructor(){}

    limpar(obj){
        return new Promise((resolve,reject)=>{
            try{
                
                let keys = Object.keys(obj)
                
                keys.forEach(function(item){
                    obj[item] = ParametrosSql.removeSqlInjection(obj[item])
                })

                resolve({params:obj})
            }catch(e){
                reject({params:undefined})
            }
        })
    }

    static removeSqlInjection(strParam){
        try{
            
            let tipoDados = typeof(strParam)
            let strReturn = strParam

            if( tipoDados == "number" ){
                return strReturn
            }

            let arrSqls = [
                "from",
                "drop",
                "database",
                "table",
                "create",
                "alter",
                "union",
                "select",
                "insert",
                "update",
                "delete"
            ]

            strReturn = strReturn.replace("*","")

            for( var i=0;i<arrSqls.length; i++ ){
                strReturn = strReturn.replace(arrSqls[i],`/*${arrSqls[i]}*/`)
            }

            strReturn = strReturn.replace("'","\'")
            strReturn = strReturn.replace('"','\"')

            return strReturn

        }catch(e){            
            return ""
        }
    }

}

module.exports = new ParametrosSql()
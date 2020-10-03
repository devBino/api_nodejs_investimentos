function estilizaSelects(){
    try{
        var campos = $('select')
        
        for( const campo of campos ){
            $(campo).addClass('class-select')
            $(campo).select2()
        }

    }catch(e){
        console.log(e)
    }
}

setTimeout(function(){
    estilizaSelects()
},600)

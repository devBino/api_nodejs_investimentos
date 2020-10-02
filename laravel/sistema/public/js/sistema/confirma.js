$(function(){

    $('.bt-deletar').click(function(){
        try{
            if( confirm('DESEJA DELETAR O REGISTRO SELECIONADO??') ){
                return true
            }else{
                return false
            }
        }catch(e){
            console.error(e)
            return false
        }
    })

})
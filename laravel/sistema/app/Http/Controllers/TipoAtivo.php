<?php
namespace App\Http\Controllers;

use App\Http\Models\TipoAtivoData;
use Illuminate\Http\Request;

class TipoAtivo{

    public function __construct(){
        TipoAtivoData::setParams();
    }
    
    public function index(){
        $data['tipos'] = TipoAtivoData::listar()['response'];
        return view('tipoAtivo.index')->with(['data'=>$data]);
    }

    public function salvar(Request $request){
        
        if( isset( $request->all()['id'] ) ){
            TipoAtivoData::alterar($request->all());
            return redirect('/tipo-ativos');
        }else{
            TipoAtivoData::salvar($request->all());
            return redirect('/tipo-ativos');
        }
    }

    public function deletar($id){
        TipoAtivoData::deletar($id);
        return redirect('/tipo-ativos');
    }

}
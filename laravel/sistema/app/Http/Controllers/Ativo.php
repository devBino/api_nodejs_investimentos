<?php
namespace App\Http\Controllers;

use App\Http\Models\TipoAtivoData;
use App\Http\Models\AtivoData;
use Illuminate\Http\Request;

class Ativo{
    
    public function __construct(){
        AtivoData::setParams();
    }

    public function index(){
        
        AtivoData::setParams();
        $data['ativos'] = AtivoData::listar()['response'];

        TipoAtivoData::setParams();
        $data['tipos']  = TipoAtivoData::listar()['response'];        
        
        return view('ativos.index')->with(['data'=>$data]);
    }

    public function salvar(Request $request){
        if( $request->all()['id'] ){
            AtivoData::alterar($request->all());
            return redirect('/ativos');
        }else{
            AtivoData::salvar($request->all());
            return redirect('/ativos');
        }
    }

    public function deletar($id){
        AtivoData::deletar($id);
        return redirect('/ativos');
    }
}
<?php 
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Models\AtivoData;
use App\Http\Repositories\Cotacao as COT;

class Cotacao{

    public function __construct(){
        AtivoData::setParams();
    }

    public function index(){
        $data['cotacoes']   = COT::listar(AtivoData::listar()['response']);
        $data['ativos']     = AtivoData::listar()['response'];

        return view('cotacao.index')->with(['data'=>$data]);
    }

    public function pesquisar(Request $request){
        $data['cotacoes']   = COT::pesquisar($request->all()['ativos']);
        $data['ativos']     = AtivoData::listar()['response'];

        return view('cotacao.index')->with(['data'=>$data]);
    }


}
@extends('template.template')
@section('contentPage')

<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Cotações dos Ativos Financeiros</h1>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-sm-12">

        <!-- Form Register -->
        <div class="row">
            <div class="col-lg-12 d-lg-block">
                <form method="post" action="/cotacao">
                    
                    <input type="hidden" name="_token" value="{!! csrf_token() !!}">
                    
                    <div class="p-5">
                    
                        <div class="form-group row">
                            
                            <div class="col-sm-10 mb-3 mb-sm-0">
                                <select name="ativos[]" id="ativos" class="form-control form-control-sm" multiple="multiple" required>
                                    <option></option>
                                    @if( isset($data['ativos']) && count($data['ativos']) )
                                        @foreach( $data['ativos'] as $num => $val )
                                            <option value="{{$val->nmAtivo}}">{{$val->nmAtivo}}</option>
                                        @endforeach
                                    @endif
                                </select>
                            </div>
                            <div class="col-sm-2 mb-3 mb-sm-0">
                                <button class="btn btn-info btn-sm pb-2"><i class="fas fa-search"></i></button>
                            </div>
                        </div>
                    </div>    
                </form>
            </div>
        </div>

        <!-- Data Table -->
        <div class="row">
            <div class="col-sm-12">
            
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Cotações</h6>
                    </div>                    
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ATIVO</th>
                                        <th>COTAÇÃO</th>
                                        <th>STATUS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                    @if( isset($data['cotacoes']) &&  count($data['cotacoes']) )
                                        @foreach($data['cotacoes'] as $num => $val)
                                            
                                            <tr>
                                                <td>{{$val['ativo']}}</td>
                                                <td>R$ {{ number_format($val['cotacao'],2,',','.')}}</td>
                                                <td>{{$val['status']}}</td>
                                            </tr>
                                        @endforeach
                                    @endif
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>

@stop
@extends('template.template')
@section('contentPage')

<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Tipos de Ativos</h1>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-sm-12">

        <!-- Form Register -->
        <div class="row">
            <div class="col-lg-12 d-lg-block">
                <form action="/tipos-ativos-salvar" method="post">
                    <div class="p-5">
                        <input type="hidden" name="_token" value="{!! csrf_token() !!}">
                        <div class="form-group row">
                            <div class="col-sm-2 mb-3 mb-sm-0">    
                                <label for="nomeAtivo">Ativo</label>
                            </div>
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" name="nomeAtivo" id="nomeAtivo" class="form-control form-control-user" placeholder="Ex Renda Fixa">
                            </div>
                            <div class="col-sm-4 mb-3 mb-sm-0">
                                <button class="btn btn-success btn-sm bt-novo"><i class="fas fa-plus"></i></button>
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
                        <h6 class="m-0 font-weight-bold text-primary">Tipos Cadastrados</h6>
                    </div>                    
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>TIPO ATIVO</th>
                                        <th colspan=2><center>-</center></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Renda Fixa</td>
                                        <td><center><span class="btn btn-info btn-sm bt-editar"><i class="fas fa-edit"></i></span></center></td>
                                        <td><center><a href="/tipos-ativos-deletar/1" class="btn btn-danger btn-sm"><i class="fas fa-trash"></i></a></center></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

@stop
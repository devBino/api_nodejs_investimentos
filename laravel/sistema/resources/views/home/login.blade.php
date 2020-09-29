<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Investimentos</title>

  <!-- Custom fonts for this template-->
  <link href="{{asset('/tema/fontawesome-free/css/all.min.css')}}" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link rel="stylesheet" href="{{asset('/css/sb-admin-2.min.css')}}">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Bem Vindo ao Cadastro de Ativos de Investimentos</h1>
                  </div>
                  <form class="user" method="post" action="/login">
                    
                    <input type="hidden" name="_token" value="{!! csrf_token() !!}">

                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="cpUsuario" name="usuario" aria-describedby="usuarioHelp" placeholder="Digite seu Usuário..." autocomplete="off">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="cdSenha" name="senha" placeholder="Digite sua Senha">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-user btn-block">Login</button>
                    </div>
                </form>                  
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="{{asset('/tema/jquery/jquery.min.js')}}"></script>
  <script src="{{asset('/tema/bootstrap/js/bootstrap.bundle.min.js')}}"></script>

  <!-- Core plugin JavaScript-->

  <script src="{{asset('/tema/jquery-easing/jquery.easing.min.js')}}"></script>

  <!-- Custom scripts for all pages-->
  <script src="{{asset('/js/sb-admin-2.min.js')}}"></script>

</body>

</html>

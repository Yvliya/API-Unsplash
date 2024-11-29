## README: API-Unsplash Mobile App

### 📱 API-Unsplash Mobile

Este é um aplicativo mobile simples desenvolvido no **Android Studio** que utiliza a API da **Unsplash** para exibir imagens de alta qualidade aleatórias no dispositivo móvel.

---

### 🚀 Funcionalidades

- **Geração de imagens aleatórias:** O aplicativo exibe imagens populares e em alta diretamente da Unsplash.
- **Tema responsivo:** Um design limpo e adaptável a diferentes tamanhos de tela, proporcionando uma ótima experiência ao usuário.

---

### 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java  
- **IDE:** Android Studio  
- **Bibliotecas:** Retrofit, Gson

---

### 📄 Estrutura Explicativa

#### 1. Descrição da API

A **API da Unsplash** permite o acesso a uma vasta biblioteca de imagens de alta qualidade. É possível buscar imagens, consultar coleções e acessar informações sobre fotógrafos. Nosso aplicativo utiliza essa API para exibir imagens aleatórias.

#### 2. URL Base e Endpoints

- **URL Base:** `https://api.unsplash.com/`
- **Endpoints principais:**
  - `/photos/random` - Retorna uma imagem aleatória.
  - Exemplos de parâmetros usados:
    - `count`: Define o número de imagens retornadas.
    - `query`: Busca imagens relacionadas a um termo específico (opcional).

#### 3. Autenticação

Para utilizar a API da Unsplash, é necessário registrar-se no [Unsplash Developers](https://unsplash.com/developers) e obter uma **chave de acesso** (Access Key).  
A chave é configurada diretamente no código:

```java
private static final String CLIENT_ID = "sua_access_key_aqui";
```

#### 4. Passo a Passo de Implementação

1. **Configuração do Retrofit:**
   - Adicione as dependências do Retrofit e Gson no arquivo `build.gradle`:
     ```gradle
     implementation 'com.squareup.retrofit2:retrofit:2.9.0'
     implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
     ```
2. **Definição do Endpoint:**
   - Crie uma interface para definir os endpoints da API.
     ```java
     public interface UnsplashApi {
         @GET("photos/random")
         Call<List<UnsplashImage>> getRandomImages(
             @Query("client_id") String clientId,
             @Query("count") int count
         );
     }
     ```
3. **Configuração do Retrofit no Código:**
   - Configure o Retrofit no aplicativo:
     ```java
     Retrofit retrofit = new Retrofit.Builder()
         .baseUrl("https://api.unsplash.com/")
         .addConverterFactory(GsonConverterFactory.create())
         .build();

     UnsplashApi api = retrofit.create(UnsplashApi.class);
     ```
4. **Requisição de Imagens:**
   - Realize a chamada para buscar imagens e exiba os dados:
     ```java
     Call<List<UnsplashImage>> call = api.getRandomImages(CLIENT_ID, 1);
     call.enqueue(new Callback<List<UnsplashImage>>() {
         @Override
         public void onResponse(Call<List<UnsplashImage>> call, Response<List<UnsplashImage>> response) {
             if (response.isSuccessful() && response.body() != null) {
                 // Processar e exibir imagem
             }
         }

         @Override
         public void onFailure(Call<List<UnsplashImage>> call, Throwable t) {
             // Tratar erro
         }
     });
     ```

5. **Exibição no Layout:**
   - Adicione os resultados ao layout usando uma `ImageView` e bibliotecas como Glide:
     ```java
     Glide.with(context)
          .load(image.getUrl())
          .into(imageView);
     ```

#### 5. Testes e Resultados

- **Exemplo de Resultado:**  
  O aplicativo exibe uma imagem aleatória retirada da Unsplash ao clicar no botão.  
  **Teste 1:** Carregou imagens corretamente ao clicar.  
  **Teste 2:** Exibiu mensagens de erro ao faltar a chave ou perder conexão com a API.

---

### 🖼️ Prévia do App

**Tela inicial (antes de buscar imagens):**  
![Tela inicial](https://github.com/user-attachments/assets/c673e2c4-aa87-4995-9873-d9695b352ee6)

**Após buscar por imagens:**  

| ![Tela com imagens 1](https://github.com/user-attachments/assets/02c8f22f-f14e-4892-b63c-d69c474ce4ae) | ![Tela com imagens 2](https://github.com/user-attachments/assets/308582bb-5ce8-4ff3-846f-66cfdd4b8de1) |  
|--------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|  

---

**Desenvolvido com 💙 por Júlia**  

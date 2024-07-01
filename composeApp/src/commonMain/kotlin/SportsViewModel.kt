import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import dev.shreyaspatil.ai.client.generativeai.type.PlatformImage
import dev.shreyaspatil.ai.client.generativeai.type.content
/*import com.google.firebase.vertexai.type.content
import com.google.firebase.Firebase
import com.google.firebase.vertexai.type.FunctionResponsePart
import com.google.firebase.vertexai.type.InvalidStateException
import com.google.firebase.vertexai.type.Schema
import com.google.firebase.vertexai.type.Tool
import com.google.firebase.vertexai.type.defineFunction
import com.google.firebase.vertexai.vertexAI*/
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SportsViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Initial)
    val uiState: StateFlow<UiState> =
        _uiState.asStateFlow()


    val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = "apiKey"
    )

    fun sendPrompt(
        prompt: String,
        imageData: ByteArray
    ) {
        _uiState.value = UiState.Loading

        val inputContent = content {
             image(PlatformImage(imageData))
            text(prompt)
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {

                val response = generativeModel.generateContent(inputContent)

                response?.text?.let { outputContent ->
                    _uiState.value = UiState.Success(outputContent)
                }

                print(response.text)

            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "")
            }
        }
    }
}
package com.example.bactrack

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bactrack.ui.theme.BACtrackTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import kotlinx.coroutines.launch
import java.util.UUID
import java.security.MessageDigest
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException


class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        auth = FirebaseAuth.getInstance()

        setContent {
            BACtrackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignInScreen()
                }
            }
        }
    }

    @Composable
    fun SignInScreen() {
        AnimatedBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp), // Adds horizontal padding for spacing
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to BACtrack",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                    modifier = Modifier.padding(bottom = 8.dp), // Adds space below the title
                    maxLines = 1 // Ensures the text remains a single line
                )
                Text(
                    text = "Sign in to track your alcohol consumption responsibly",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                        lineHeight = 22.sp,
                        color = Color(0xFFECEFF1)
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp), // Horizontal padding for better alignment
                    textAlign = TextAlign.Center // Center-align the text
                )
                Spacer(modifier = Modifier.height(32.dp))
                GoogleSignInButton()
                Spacer(modifier = Modifier.height(16.dp))
                GithubButton()
            }
        }
    }


    @Composable
    fun GoogleSignInButton() {
        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()

        val onClick: () -> Unit = {
            val credentialManager = CredentialManager.create(context)

            val rawNonce = UUID.randomUUID().toString()
            val bytes = rawNonce.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            val hashedNonce = digest.fold("") { str, it -> str + "%02x".format(it) }

            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId("44637818454-2fu80osaqikevbdfrl6s1cv06nfvo1ov.apps.googleusercontent.com")
                .setNonce(hashedNonce)
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            coroutineScope.launch {
                try {
                    val result = credentialManager.getCredential(request = request, context = context)
                    val credential = result.credential

                    val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                    val googleIdToken = googleIdTokenCredential.idToken
                    val displayName = googleIdTokenCredential.displayName

                    val intent = Intent(context, Landing::class.java).apply {
                        putExtra("USERNAME", displayName)
                    }
                    Log.i("TAG", "User display name: $displayName")
                    Log.i("TAG", googleIdToken)

                    Toast.makeText(context, "Signed in", Toast.LENGTH_SHORT).show()
                    context.startActivity(intent)
                    (context as? ComponentActivity)?.finish()
                } catch (e: GetCredentialException) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                } catch (e: GoogleIdTokenParsingException) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        Button(
            onClick = onClick,  // Use the Google Sign-in logic in the button's onClick
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4285F4)),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Google Icon",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Sign in with Google", color = Color.White)
        }
    }

    @Composable
    fun GithubButton() {
        Button(
            onClick = { signInWithGithub() },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_github),
                contentDescription = "GitHub Icon",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Sign in with GitHub", color = Color.White)
        }
    }

    private fun signInWithGithub() {
        val provider = OAuthProvider.newBuilder("github.com")
        provider.addCustomParameter("allow_signup", "false")

        auth.startActivityForSignInWithProvider(this, provider.build())
            .addOnSuccessListener { authResult ->
                val user = authResult.user
                val email = user?.email ?: "No email"
                val username = user?.displayName ?: email.substringBefore("@")
                val githubId = user?.uid ?: "No ID"

                val intent = Intent(this, Landing::class.java).apply {
                    putExtra("EMAIL", email)
                    putExtra("USERNAME", username)
                    putExtra("GITHUB_ID", githubId)
                }
                Toast.makeText(this, "Sign-in successful: ${authResult.user?.email}", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Sign-in failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}

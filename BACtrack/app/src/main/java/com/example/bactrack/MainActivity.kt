package com.example.bactrack


import android.content.Intent
import android.os.Bundle

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bactrack.ui.theme.BACtrackTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.FirebaseApp
import android.widget.Toast
import com.google.firebase.auth.OAuthProvider
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.launch
import java.security.MessageDigest
import java.util.UUID

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        // Get the FirebaseAuth instance
        auth = FirebaseAuth.getInstance()

        setContent {
            BACtrackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {

                        GoogleSignInButton()
                        GithubButton()
                    }
                }
            }
        }
    }


    private fun signInWithGithub() {
        val provider = OAuthProvider.newBuilder("github.com")

        // Optionally add additional scopes
        provider.addCustomParameter("allow_signup", "false")

        // Start the sign-in flow
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
                Toast.makeText(
                    this,
                    "Sign-in successful: ${authResult.user?.email}",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(intent)
                finish()
            }
            .addOnFailureListener { e ->
                // Handle failure
                Toast.makeText(this, "Sign-in failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }


    @Composable
    fun GithubButton() {
        Box(
            modifier = Modifier
                .fillMaxSize() // Fill the entire screen
                .padding(16.dp), // Optional padding around the box
            contentAlignment = Alignment.Center // Center the content
        ) {
            Button(onClick = { signInWithGithub() }) {
                Text("Github Sign In")
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

            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId("44637818454-2fu80osaqikevbdfrl6s1cv06nfvo1ov.apps.googleusercontent.com")
                .setNonce(hashedNonce)
                .build()

            val request: GetCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)

                .build()
            coroutineScope.launch {
                try {

                    val result = credentialManager.getCredential(
                        request = request,
                        context = context,
                    )
                    val credential = result.credential

                    val googleIdTokenCredential = GoogleIdTokenCredential
                        .createFrom(credential.data)
                    val googleIdToken = googleIdTokenCredential.idToken

                    val displayName = googleIdTokenCredential.displayName

                    val intent = Intent(context, Landing::class.java).apply {
                        putExtra("USERNAME", displayName)
                    }
                    Log.i("TAG", "User display name: $displayName")
                    Log.i("TAG", googleIdToken)



                    Toast.makeText(context, "Signed in", Toast.LENGTH_SHORT).show()


                    context.startActivity(intent)
                    finish()
                } catch (e: GetCredentialException) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                } catch (e: GoogleIdTokenParsingException) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            }

        }

        Button(onClick = onClick) {
            Text("Google")

        }


    }


}

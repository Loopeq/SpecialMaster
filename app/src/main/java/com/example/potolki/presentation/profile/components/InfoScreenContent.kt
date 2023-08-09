package com.example.potolki.presentation.profile.components

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.potolki.R
import com.example.potolki.domain.model.UserProfile
import com.example.potolki.presentation.profile.ProfileScreenViewModel


@Composable
fun InfoScreenContent(
    modifier: Modifier = Modifier,
    userInfo: UserProfile,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    val textStyle: TextStyle = MaterialTheme.typography.h4.copy(fontSize = 14.sp)
    val variantTextStyle: TextStyle = MaterialTheme.typography.h3.copy(fontSize = 14.sp)

    var phoneTextFieldValue by remember { mutableStateOf(userInfo.phone) }
    var emailTextFieldValue by remember { mutableStateOf(userInfo.email) }
    var nameTextFieldValue by remember { mutableStateOf(userInfo.firstName) }
    var lastNameTextFieldValue by remember { mutableStateOf(userInfo.lastName) }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp),
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            Card(elevation = 4.dp, modifier = Modifier.fillMaxWidth().height(180.dp).padding(start = 20.dp, end = 20.dp)) {
                Icon(
                    Icons.Filled.PhotoCamera, contentDescription = "photo",
                    tint = Color.LightGray, modifier = Modifier.size(128.dp)
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Column(Modifier.padding(start = 8.dp)) {
                Text(text = stringResource(id = R.string.name), style = textStyle)
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(value = nameTextFieldValue, onValueChange = {
                    nameTextFieldValue = it
                }, textStyle = variantTextStyle,
                    modifier = Modifier,
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Person, contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    })
            }
        }


        item {
            Column(Modifier.padding(start = 8.dp)) {
                Text(text = stringResource(id = R.string.surname), style = textStyle)
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(value = lastNameTextFieldValue, onValueChange = {
                    lastNameTextFieldValue = it
                }, textStyle = variantTextStyle,
                    modifier = Modifier,
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Person, contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    })
            }
        }

        item {
            Column(Modifier.padding(start = 8.dp)) {
                Text(text = stringResource(id = R.string.phone), style = textStyle)
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(value = phoneTextFieldValue, onValueChange = {
                    phoneTextFieldValue = it
                }, textStyle = variantTextStyle,
                    modifier = Modifier,
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Phone, contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    })
            }
        }

        item {
            Column(Modifier.padding(start = 8.dp)) {
                Text(text = stringResource(id = R.string.email), style = textStyle)
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(value = emailTextFieldValue, onValueChange = {
                    emailTextFieldValue = it
                }, textStyle = variantTextStyle,
                    modifier = Modifier,
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Mail, contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    })
            }
        }

        item {
            Card(modifier = Modifier.fillMaxWidth(), elevation = 5.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                ) {
                    Text(text = stringResource(id = R.string.pay_metodes), style = variantTextStyle)
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Card(
                            modifier = Modifier,
                            backgroundColor = MaterialTheme.colors.primaryVariant,
                            contentColor = Color.Black,
                            elevation = 0.dp,
                            border = BorderStroke(width = 1.dp, color = Color.LightGray)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(20.dp)
                            ) {
                                Icon(
                                    Icons.Filled.AddCard,
                                    contentDescription = "add_card",
                                    modifier = Modifier.size(32.dp)
                                )
                                Text(
                                    text = stringResource(id = R.string.add_card),
                                    style = textStyle
                                )
                            }

                        }
                    }
                }

            }

        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}




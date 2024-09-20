@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package krona.composeapp.generated.resources

import kotlin.OptIn
import org.jetbrains.compose.resources.DrawableResource

private object CommonMainDrawable0 {
  public val Calendar: DrawableResource by 
      lazy { init_Calendar() }

  public val Events: DrawableResource by 
      lazy { init_Events() }

  public val MainPage: DrawableResource by 
      lazy { init_MainPage() }

  public val PersonalAccount: DrawableResource by 
      lazy { init_PersonalAccount() }

  public val compose_multiplatform: DrawableResource by 
      lazy { init_compose_multiplatform() }
}

internal val Res.drawable.Calendar: DrawableResource
  get() = CommonMainDrawable0.Calendar

private fun init_Calendar(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:Calendar",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/krona.composeapp.generated.resources/drawable/Calendar.png", -1, -1),
    )
)

internal val Res.drawable.Events: DrawableResource
  get() = CommonMainDrawable0.Events

private fun init_Events(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:Events",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/krona.composeapp.generated.resources/drawable/Events.png", -1, -1),
    )
)

internal val Res.drawable.MainPage: DrawableResource
  get() = CommonMainDrawable0.MainPage

private fun init_MainPage(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:MainPage",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/krona.composeapp.generated.resources/drawable/MainPage.png", -1, -1),
    )
)

internal val Res.drawable.PersonalAccount: DrawableResource
  get() = CommonMainDrawable0.PersonalAccount

private fun init_PersonalAccount(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:PersonalAccount",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/krona.composeapp.generated.resources/drawable/PersonalAccount.png", -1, -1),
    )
)

internal val Res.drawable.compose_multiplatform: DrawableResource
  get() = CommonMainDrawable0.compose_multiplatform

private fun init_compose_multiplatform(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:compose_multiplatform",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/krona.composeapp.generated.resources/drawable/compose-multiplatform.xml", -1, -1),
    )
)

package meteor.ui.composables.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import meteor.ui.composables.preferences.background

class ToolbarButton(
    var name: String, var icon: ImageVector?, var imageResource: String? = null, var iconColor: Color? = Color.Cyan,
    var backgroundColor: Color? = background ,
    var description: String? = "", var alignment: Alignment = Alignment.TopCenter,
    var bottom: Boolean = false, var onClick: () -> Unit
) {

    //Required for java access
    constructor(
        name: String, imageResource: String,
        description: String, alignment: Alignment,
        bottom: Boolean, onClick: () -> Unit
    ) :
            this(
                name,
                icon = null,
                imageResource = imageResource,
                backgroundColor = background ,
                description = description,
                alignment = alignment,
                bottom = bottom,
                onClick = onClick
            )

    @Composable
    fun CreateComponent() {
        Box(
            modifier = Modifier.clip(CircleShape).background(backgroundColor!!).width(45.dp).height(45.dp),
            contentAlignment = alignment
        ) {
            IconButton(
                onClick = onClick,
                modifier = Modifier.align(Alignment.Center)
            ) {
                if (icon != null)
                    Icon(
                        icon!!,
                        contentDescription = description,
                        tint = iconColor!!
                    )
                else if (imageResource != null)
                    Image(
                        painter = painterResource(imageResource!!),
                        contentDescription = description
                    )
            }
        }
        Spacer(
            Modifier.height(10.dp)
                .background(background )
        )
    }
}
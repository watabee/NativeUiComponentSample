import {
  NativeSyntheticEvent,
  requireNativeComponent,
  UIManager,
  ViewProps,
} from 'react-native'

type ColorChangedData = {
  color: string
}

type RainbowViewProps = Readonly<
  {
    updateMillis?: number
    onColorChanged?: (e: NativeSyntheticEvent<ColorChangedData>) => void
  } & ViewProps
>

export const RainbowView =
  requireNativeComponent<RainbowViewProps>('RainbowView')

export const DEFAULT_INT_VALUE =
  UIManager.RainbowView.Constants.DEFAULT_INT_VALUE

export const DEFAULT_STRING_VALUE =
  UIManager.RainbowView.Constants.DEFAULT_STRING_VALUE

export const start = (viewId: number | null) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    UIManager.RainbowView.Commands.start.toString(),
    []
  )

export const stop = (viewId: number | null) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    UIManager.RainbowView.Commands.stop.toString(),
    []
  )
